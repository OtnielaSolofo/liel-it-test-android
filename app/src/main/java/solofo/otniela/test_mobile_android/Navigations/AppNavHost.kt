package solofo.otniela.test_mobile_android.Navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import solofo.otniela.test_mobile_android.Views.DetailOperation
import solofo.otniela.test_mobile_android.Views.ListAccount
import solofo.otniela.test_mobile_android.ViewModels.BankViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
    bankViewModel: BankViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) { backStackEntry ->
            ListAccount(
                bankViewModel,
                navController
            )
        }
        composable(NavigationItem.Details.route+ "/{operations}"+ "/{label}"+ "/{balance}") { backStackEntry ->
            val operations = backStackEntry.arguments?.getString("operations")
            val label = backStackEntry.arguments?.getString("label")
            val balance = backStackEntry.arguments?.getString("balance")
            if (operations != null && label != null && balance != null) {
                DetailOperation(navController = navController)
            }
        }
    }
}