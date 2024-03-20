package solofo.otniela.test_mobile_android.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import solofo.otniela.test_mobile_android.BankRepository
import solofo.otniela.test_mobile_android.Models.Bank
import solofo.otniela.test_mobile_android.apiService

class BankViewModel : ViewModel() {
    private val bankRepository = BankRepository(apiService)

    val banks: LiveData<List<Bank>> = liveData {
        val data = bankRepository.getBanks()
        emit(data)
    }
}