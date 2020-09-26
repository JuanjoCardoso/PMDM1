fun main() {
    println("Hello World.")
    assignReadersToBooks()

    exercise1()

    exercise2()

    System.out.println("NIF: "+exercise3("73398626"))

    println("number of a's = " + countAs("Mary got married"))

    exercise5()

    printStringLength("This is a test")
    printStringLength(null)

    println("Concatenation: " + concatenate("hello", null))
    println("Concatenation: " + concatenate(null, "world"))
    println("Concatenation: " + concatenate(null, null))
    println("Concatenation: " + concatenate("hello", "world"))
}

// TODO: 1.- Write a function called exercise1()
// that prints the numbers from 1 to 10 with
// println() and invoke it from main().
// Look for how to make a “for” loop here:
// https://kotlinlang.org/docs/reference/control-flow.html

fun exercise1(){
    for (i in 1..10){
        println(i)
    }
}

// TODO: 2.- Uncomment this function:
fun exercise2() {
    var month = 1
    while(month != 0) {
        println("Enter the number of the month (0 to finish)")
        val monthStr = readLine()
        if (month > 0 && month <= 12) {
            month = monthStr!!.toInt() // Don't worry about the !! yet. We will study it later
            // TODO: 2 write the number of days that has that month, using the "when" structure
            // You can read about it here:
            // https://kotlinlang.org/docs/reference/control-flow.html
            // take into account that some months have 30, others 31 and one 28 or 29.
            // Invoke the function from main()
            when (month){
                1 -> println("January has 31 days")
                2 -> println("February has 28 or 29 days")
                3 -> println("March has 31 days")
                4 -> println("April has 30 days")
                5 -> println("May has 31 days")
                6 -> println("June has 30 days")
                7 -> println("July has 31 days")
                8 -> println("August has 31 days")
                9 -> println("September has 30 days")
                10 -> println("October has 31 days")
                11 -> println("November has 30 days")
                12 -> println("December has 31 days")
            }
        }
    }
}

// TODO: 3 Write a function called exercise3()
// that accepts a  number and returns a String
// that represents the corresponding NIF (number + letter)
// https://www.ordenacionjuego.es/en/calculo-digito-control
// https://kotlinlang.org/docs/reference/basic-types.html#arrays

fun exercise3(numStr:String): String{
    var num=1
    var aux=0
    val letters = arrayOf("T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E")
    var lett=""

    num = numStr!!.toInt()
    if (num > 0 && num < 100000000 ){
        aux=num%23
        lett=letters[aux]
    }
    val nif=num.toString()+lett
    return(nif)
}

// TODO: 4 Modify this function abbreviating it with "=" as return type
// (simplification 2)
// https://developer.android.com/kotlin/learn#simplifying
// Note: You can remove the : Int in the declaration
fun countAs(str: String) = str.count { c -> c == 'a' }
//{
    //val count = str.count { c -> c == 'a' }
    //return count
//}


fun stringMapper(str: String, mapper: (String) -> Int): Int {
    return mapper(str)
}
// TODO 5: Write a function called exercise5()
// In it you will invoke the function stringMapper declared above twice.
// The first one with a function that returns the number of characters
// and the second one with a function that returns the number of a’s.
// Print its results.

fun exercise5(){
    println("Please, write a word")
    val word = readLine()
    print("Number of characters of your word: ")
    println(stringMapper(word.toString(),{ input -> input.length}))
    println("")
    print("Number of A's of the word: ")
    println(stringMapper(word.toString(),{ input -> countAs(input)}))
    println("")
}


data class Reader(val name: String, val age: Int)

data class Book(val name: String, var reader: Reader)

// TODO 6: Create a data class Book that has 2 parameters
// title as a String that can not be modified (read only)
// and reader as a Reader
fun assignReadersToBooks() {
    val reader1 = Reader("John", 23)
    val reader2 = Reader("Mary", 34)
    // TODO 6: Uncomment these sentences
     val book1 = Book("The name of the wind", reader1)
     book1.reader = reader2
}

// TODO 7: Write the body of this function
// That prints the length of the string parameter.
// If the string is null, print 0
fun printStringLength(string: String?) {
    print("The length of the string is: ")
    if (string != null) {
        println("length = " + (string?.length ?: 0))
    }else {
        println("0")
    }
}

// TODO 8: Write a method concatenate() that concatenates 2 Strings
// received as parameters.
// If a String is null, convert it to “”.
// This is the invocation:
// println("Concatenation: " + concatenate("hello", null))
fun concatenate(string1: String?, string2: String?): String {
    val a:String
    if (string1 != null) {
        if (string2 != null) {
            a= string1+string2
        }else{
            a= string1+""
        }
    } else {
        if (string2 != null) {
            a= "" + string2
        } else {
            a= ""+""
        }
    }
    return a
}