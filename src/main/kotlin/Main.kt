import java.util.Scanner

fun main(args: Array<String>) {
    start()
}

private val scanner = Scanner(System.`in`)
private val archiveStore = ArchiveStore()

fun start() {
    val menu = Menu(scanner)

    menu.show(
        "Archives",
        archiveStore.archiveList,
        onExit = {
            scanner.close()
        },
        onItem = { archiveItem ->
            val archive = archiveItem as Archive
            menu.show("Notes", archive.noteList,
                onNew = {
                    archive.addNewNote()
                },
                onItem = { noteItem ->
                    val note = noteItem as Note
                    println("/n${note.text}/n")
                },
                onExit = {
                }
            )
        },
        onNew = {
            addNewArchive()
        }
    )
}

fun addNewArchive() {
    val archiveName = readLine("Введите название архива: ", "Название архива не может быть пустым")
    archiveStore.archiveList.add(Archive(archiveName))
    println("Архив $archiveName создан!")
}

fun Archive.addNewNote() {
    val noteName = readLine("Введите название заметки: ", "Название заметки не может быть пустым")
    val noteText = readLine("Введите текст: ", "Текст не может быть пустым")

    noteList.add(Note(noteName, noteText))
    println("Заметка создана!\nДля архива $name")
}

private fun readLine(title: String, errorMessage: String): String {
    var line: String
    while (true) {
        println(title)
        line = scanner.nextLine()
        if (line.isNotBlank()) {
            break
        } else {
            println(errorMessage)
        }
    }
    return line
}