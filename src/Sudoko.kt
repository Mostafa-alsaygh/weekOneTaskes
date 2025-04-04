fun main() {
    fun check(name: String, result: Boolean, correctResult: Boolean) {
        println(if (result == correctResult) "✅ $name" else "❌ $name")
    }

    println("|--- Running Sudoku Validator Tests ---|")

    //valid cases

    check(
        name = "Valid empty 3x3 grid",
        result = isValidSudoku(List(3) { List(3) { '-' } }),
        correctResult = true
    )

    check(
        name = "Valid complete 3x3 grid (mini Sudoku)",
        result = isValidSudoku(
            listOf(
                listOf('3', '1', '2'),
                listOf('1', '2', '3'),
                listOf('2', '3', '1')
            ),
            subgridSize = 1
        ),
        correctResult = true
    )

    check(
        name = "Valid 4x4 grid",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = true
    )

    check(
        name = "Grid with one filled cell",
        result = isValidSudoku(
            listOf(
                listOf('1', '-', '-', '-'),
                listOf('-', '-', '-', '-'),
                listOf('-', '-', '-', '-'),
                listOf('-', '-', '-', '-')
            ), 2
        ),
        correctResult = true
    )

    check(
        name = "Valid empty 9x9 grid",
        result = isValidSudoku(List(9) { List(9) { '-' } }),
        correctResult = true
    )

    check(
        name = "Valid complete 9x9 grid",
        result = isValidSudoku(
            listOf(
                listOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                listOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                listOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                listOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
            )
        ),
        correctResult = true
    )

    check(
        name = "Valid complete 16x16 grid",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
                listOf('3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2'),
                listOf('2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F'),
                listOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
                listOf('4', '3', '2', '1', '8', '7', 'F', 'E', 'G', 'D', '5', '6', '9', 'A', 'B', 'C'),
                listOf('7', '8', '9', 'A', 'B', 'C', 'D', '1', '2', '3', '4', '5', '6', 'F', 'E', 'G'),
                listOf('6', '5', '1', '2', '3', '4', 'E', 'D', 'C', 'B', 'A', '9', '8', '7', 'G', 'F'),
                listOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
                listOf('8', '7', '6', '5', '4', '3', '2', '1', 'E', 'F', 'G', 'D', 'C', 'B', 'A', '9'),
                listOf('A', '9', '8', '7', 'F', 'E', 'D', 'C', 'B', 'A', '1', '2', '3', '4', '5', '6'),
                listOf('B', 'C', 'D', 'E', 'G', 'F', 'A', '9', '8', '7', '6', '5', '4', '3', '2', '1'),
                listOf('C', 'B', 'A', '9', '2', '1', '5', '4', '3', 'D', 'E', 'F', 'G', '8', '7', '6'),
                listOf('D', 'E', 'F', 'G', '1', '2', '3', 'B', '4', '5', '7', '8', 'A', '9', '6', 'C'),
                listOf('E', 'D', 'G', 'F', '7', '8', '6', 'A', '5', 'C', '9', 'B', '2', '1', '4', 'D'),
                listOf('F', 'G', 'E', 'D', 'A', '9', 'C', '5', '6', '1', '8', '7', 'B', 'G', 'F', 'E'),
                listOf('G', 'F', 'C', 'B', 'E', 'D', '1', '2', '7', '8', '2', 'A', 'F', '5', '9', '3')
            ), 4
        ),
        correctResult = true
    )

    //invalid cases

    check(
        name = "Invalid 3x3 grid (duplicate in row)",
        result = isValidSudoku(
            listOf(
                listOf('3', '1', '1'),
                listOf('1', '2', '3'),
                listOf('2', '3', '1')
            ),
            subgridSize = 1
        ),
        correctResult = false
    )

    check(
        name = "4x4 with invalid number '5'",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '5'),
                listOf('3', '4', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 grid with subgrid 3 duplicated",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '1', '3'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), subgridSize = 2
        ),
        correctResult = false
    )

    check(
        name = "Invalid grid dimensions",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3'),
                listOf('4', '1', '2'),
                listOf('2', '3', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 with row duplicate",
        result = isValidSudoku(
            listOf(
                listOf('1', '1', '3', '4'),
                listOf('3', '4', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 with column duplicate",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '2', '1'),
                listOf('2', '4', '1', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "Grid with invalid characters",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', 'X', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 valid rows/columns but invalid subgrid",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('2', '1', '4', '3'),
                listOf('3', '4', '1', '2'),
                listOf('4', '3', '2', '1')
            ), 3
        ),
        correctResult = false
    )

    check(
        name = "5x4 rectangular grid",
        result = isValidSudoku(
            listOf(
                List(4) { '-' },
                List(4) { '-' },
                List(4) { '-' },
                List(4) { '-' },
                List(4) { '-' }
            ), subgridSize = 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 grid with subgridSize=3",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), subgridSize = 3
        ),
        correctResult = false
    )

    check(
        name = "inValid incomplete 16x16 grid",
        result = isValidSudoku(
            listOf(
                listOf('1', '-', '-', '4', '-', '-', '-', '8', '-', '-', '-', 'C', '-', '-', '-', 'G'),
                listOf('-', '2', '-', '-', '-', '6', '-', '-', '-', 'A', '-', '-', '-', 'E', '-', '-'),
                listOf('-', '-', '-', 'D', '-', '-', '-', '1', '-', '-', '-', '5', '-', '-', '-', '9')
            ), 4
        ),
        correctResult = false
    )

    check(
        name = "16x16 with lowercase 'a'",
        result = isValidSudoku(
            listOf(
                listOf('1', '-', '-', '4', '-', '-', '-', '8', '-', '-', '-', 'C', '-', '-', '-', 'G'),
                listOf('-', '2', '-', '-', '-', '6', '-', '-', '-', 'a', '-', '-', '-', 'E', '-', '-'),
            ) + List(14) { List(16) { '-' } }, 4
        ),
        correctResult = false
    )

    check(
        name = "9x9 with invalid, subgrid 5 duplicated in bottom right ",
        result = isValidSudoku(
            listOf(
                listOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                listOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                listOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                listOf('3', '4', '5', '2', '8', '6', '1', '7', '5')
            )
        ),
        correctResult = false
    )

    check(
        name = "9x9 with invalid, there is invalid char",
        result = isValidSudoku(
            listOf(
                listOf('#', '3', '4', '6', '7', '8', '9', '1', '2'),
                listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                listOf('1', '9', '8', '3', '@', '2', '5', '6', '7'),
                listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                listOf('7', '^', '3', '9', '2', '4', '8', '5', '6'),
                listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                listOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
            )
        ),
        correctResult = false
    )

    check(
        name = "9x9 with invalid, there is invalid SPACE",
        result = isValidSudoku(
            listOf(
                listOf(' ', '3', '4', '6', '7', '8', '9', '1', '2'),
                listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                listOf('1', '9', '8', '3', '@', '2', '5', '6', '7'),
                listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                listOf('7', '^', '3', '9', '2', '4', '8', '5', '6'),
                listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                listOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
            )
        ),
        correctResult = false
    )

}

fun isValidSudoku(grid: List<List<Char>>, subgridSize: Int = 3): Boolean {
    return false
}