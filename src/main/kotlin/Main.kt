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
                    archive.addNewNote(scanner)
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
            archiveStore.createArchive(scanner)
        }
    )
}