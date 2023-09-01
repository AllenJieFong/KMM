package presentation

import data.model.Product
import data.repository.ProductRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ProductsUiState(
    val products: List<Product> = emptyList(),
    val currentIndex: Int = 0
) {
    fun getProduct(index: Int) = products[index]
}

class ProductViewModel: ViewModel() {
    private val _currentPage = MutableStateFlow("Products")
    val currentPage: StateFlow<String> = _currentPage

    fun navigateTo(pageName: String) {
        _currentPage.value = pageName
    }

    private val _uiState = MutableStateFlow(ProductsUiState())
    val uiState = _uiState.asStateFlow()

    private val productRepository = ProductRepository()

    init {
        loadTopProducts()
    }

    override fun onCleared() {
        productRepository.close()
    }

    private fun loadTopProducts() {
        viewModelScope.launch {
            val res = ProductRepository().getTopProduct()
            println("Response: $res")
            _uiState.update {
                it.copy(products = res.data?.products ?: listOf())
            }
        }
    }

    fun setCurrentIndex(index: Int) {
        _uiState.update {
            it.copy(currentIndex = index)
        }
    }
}