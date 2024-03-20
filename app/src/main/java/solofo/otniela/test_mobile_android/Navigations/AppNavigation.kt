package solofo.otniela.test_mobile_android.Navigations

enum class Screen {
    HOME,
    DETAILS,
}
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Details : NavigationItem(Screen.DETAILS.name + "/{operations}"  + "/{label}"  + "/{balance}")
}