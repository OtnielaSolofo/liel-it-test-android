package solofo.otniela.test_mobile_android.Views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import solofo.otniela.test_mobile_android.Models.Bank
import solofo.otniela.test_mobile_android.Navigations.NavigationItem

@Composable
fun CollapsibleBankItem(bank: Bank, expanded: Boolean, navController: NavController) {
    var isExpanded by remember { mutableStateOf(expanded) }

    Column {
        Row(
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = bank.name, fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f))
            Icon(
                imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand/Collapse"
            )
        }

        if (isExpanded) {
            bank.accounts.forEach { account ->
                Column(
                    modifier = Modifier
                        .padding(10.dp),
                ) {
                    Text(
                        text = account.label,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navController.navigate("${NavigationItem.Details.route}/${account.recentOperationsFirst.joinToString(",")}/${account.label}/${account.balance}")
                        }
                    )
                    Text(
                        text = "Balance: " + account.balance + "€",
                        modifier = Modifier.clickable {
                            navController.navigate("${NavigationItem.Details.route}/${account.recentOperationsFirst.joinToString(",")}/${account.label}/${account.balance}")
                        }
                    )
                }
            }
        }
    }
}