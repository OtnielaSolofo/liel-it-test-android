package solofo.otniela.test_mobile_android.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import solofo.otniela.test_mobile_android.Models.Operation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailOperation(navController: NavController) {
    val operations = remember {
        val args = navController.currentBackStackEntry?.arguments?.getString("operations") ?: ""
             args.split("Operation")
    }
    val label = navController.currentBackStackEntry?.arguments?.getString("label") ?: ""
    val balance = navController.currentBackStackEntry?.arguments?.getString("balance") ?: ""

    val operationList = operations.map {
        parseOperation(it)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,

        ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
            ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Text(
                text = balance + " €" ,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = label ,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
            )
            OperationList(operationList)
        }
    }
}

fun parseOperation(operationString: String): Operation? {
    val parts = operationString.split(", ")
    if (parts.size == 5) {
        val id = parts[0].substringAfter("id=").trim()
        val amount = parts[1].substringAfter("amount=").trim()
        val category = parts[2].substringAfter("category=").trim()
        val date = parts[3].substringAfter("date=").trim()
        val title = parts[4].substringAfter("title=").substringBefore(")").trim()
        return Operation(id, amount, category, date, title)
    }
    return null
}

@Composable
fun OperationList(operations: List<Operation?>) {
    Column {
        operations.forEach { operation ->
            if (operation != null){
                Row(
                    modifier = Modifier
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)) {
                        Text(
                            text = operation.title ,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            text = operation.date ,
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                    Text(
                        text = operation.amount + " €",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}
