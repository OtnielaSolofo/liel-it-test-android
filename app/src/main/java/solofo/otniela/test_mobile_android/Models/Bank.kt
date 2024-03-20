package solofo.otniela.test_mobile_android.Models

data class Bank(
    val name: String,
    val isCA: Int,
    val accounts: List<Account>
)