package solofo.otniela.test_mobile_android.Views

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import solofo.otniela.test_mobile_android.ViewModels.BankViewModel
import solofo.otniela.test_mobile_android.Views.BankList

@Composable
fun ListAccount(bankViewModel: BankViewModel, navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,

            ) {
            Text(text = "Mes comptes", style = MaterialTheme.typography.headlineMedium)
            BankList(bankViewModel, navController)
        }
}