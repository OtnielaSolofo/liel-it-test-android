package solofo.otniela.test_mobile_android.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import solofo.otniela.test_mobile_android.Models.Bank
import solofo.otniela.test_mobile_android.ViewModels.BankViewModel

@Composable
fun BankList(bankViewModel: BankViewModel, navController: NavController) {
    val banks by bankViewModel.banks.observeAsState(initial = emptyList())

//    LazyColumn {
//        if (banks.isNotEmpty()) {
//            items(banks.size) { index ->
//                CollapsibleBankItem(banks[index], false,navController)
//            }
//        }
//    }
    Column {
        SectionBankA(banks, navController)
        SectionBankB(banks, navController)
    }
//        if (banks.isNotEmpty()) {
//            items(banks.size) { sectionIndex ->
//                when (sectionIndex) {

//                }
//            }
//        }
//    }
}

@Composable
fun SectionBankA(banks: List<Bank>, navController: NavController) {
    Column {
        Text(
            text ="Crédit Agricole" ,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 10.dp)
        )
        LazyColumn {
            if (banks.isNotEmpty()) {
                items(banks.size) { index ->
                    if (banks[index].name == "CA Languedoc"){
                        CollapsibleBankItem(banks[index], false,navController)
                    }
                }
            }
        }
    }
}

@Composable
fun SectionBankB(banks: List<Bank>, navController: NavController) {
    Column {
        Text(
            text ="Autres banques" ,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 10.dp)
        )
        LazyColumn {
            if (banks.isNotEmpty()) {
                items(banks.size) { index ->
                    if (banks[index].name != "CA Languedoc"){
                        CollapsibleBankItem(banks[index], false,navController)
                    }
                }
            }
        }

    }
}
