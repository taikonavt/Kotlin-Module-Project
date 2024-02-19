import java.util.Scanner

class Menu(private val scanner: Scanner) {

    fun show(
        title: String,
        items: List<Item>,
        onExit: () -> Unit,
        onItem: (item: Item) -> Unit,
        onNew: () -> Unit)
    {
        loop@ while (true) {
            val lastMenuOptionsIndex = items.size + 1
            println("$title:")
            println("0 - Выход")
            items.forEachIndexed { index, item ->
                println("${index + 1} - Открыть ${item.name}")
            }
            println("$lastMenuOptionsIndex - Новый")
            while (true) {
                val line = scanner.nextLine().toIntOrNull()
                when {
                    line == null || line < 0 || line > lastMenuOptionsIndex -> {
                        println("Неверный ввод. Пожалуйста, введите число от 0 до $lastMenuOptionsIndex!")
                    }
                    line == 0 -> {
                        onExit()
                        break@loop
                    }
                    line in 1 until lastMenuOptionsIndex -> {
                        onItem(items[line - 1])
                        break
                    }
                    line == lastMenuOptionsIndex -> {
                        onNew()
                        break
                    }
                }
            }
        }
    }
}