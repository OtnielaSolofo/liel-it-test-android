package solofo.otniela.test_mobile_android.Models

data class Account(
    val id: String,
    val contract_number: String,
    val holder: String,
    val label: String,
    val balance: Double,
    val operations: List<Operation>,
    val order: Int,
    val role: Int,
    val product_code: String
) {
    val recentOperationsFirst: List<Operation>
        get() = operations.sortedWith(compareBy({ it.date }, { it.title }))
}