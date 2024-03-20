package solofo.otniela.test_mobile_android

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import solofo.otniela.test_mobile_android.Models.Bank

class BankRepository(private val apiService: ApiService) {
//    suspend fun getBanks(): List<Bank> {
//        return apiService.getBanks()
//    }
    fun getBanks(jsonString: String = "[\n" +
        "    {\n" +
        "        \"accounts\": [\n" +
        "            {\n" +
        "                \"balance\": 2031.84,\n" +
        "                \"contract_number\": \"32216549871\",\n" +
        "                \"holder\": \"Corinne Martin\",\n" +
        "                \"id\": \"151515151151\",\n" +
        "                \"label\": \"Compte de dépôt\",\n" +
        "                \"operations\": [\n" +
        "                    {\n" +
        "                        \"amount\": \"-15,99\",\n" +
        "                        \"category\": \"leisure\",\n" +
        "                        \"date\": \"1644870724\",\n" +
        "                        \"id\": \"2\",\n" +
        "                        \"title\": \"Prélèvement Netflix\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"amount\": \"-95,99\",\n" +
        "                        \"category\": \"online\",\n" +
        "                        \"date\": \"1644611558\",\n" +
        "                        \"id\": \"4\",\n" +
        "                        \"title\": \"CB Amazon\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"order\": 1,\n" +
        "                \"product_code\": \"00004\",\n" +
        "                \"role\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"balance\": 843.15,\n" +
        "                \"contract_number\": \"09320939231\",\n" +
        "                \"holder\": \"M. et Mme Martin\",\n" +
        "                \"id\": \"9892736780987654\",\n" +
        "                \"label\": \"Compte joint\",\n" +
        "                \"operations\": [\n" +
        "                    {\n" +
        "                        \"amount\": \"-15,99\",\n" +
        "                        \"category\": \"leisure\",\n" +
        "                        \"date\": \"1644784369\",\n" +
        "                        \"id\": \"2\",\n" +
        "                        \"title\": \"Prélèvement Netflix\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"amount\": \"-750,00\",\n" +
        "                        \"category\": \"housing\",\n" +
        "                        \"date\": \"1644179569\",\n" +
        "                        \"id\": \"3\",\n" +
        "                        \"title\": \"Prélèvement Century 21\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"order\": 2,\n" +
        "                \"product_code\": \"00007\",\n" +
        "                \"role\": 2\n" +
        "            },\n" +
        "            {\n" +
        "                \"balance\": 209.39,\n" +
        "                \"contract_number\": \"29389382872\",\n" +
        "                \"holder\": \"Thaïs Martin\",\n" +
        "                \"id\": \"2354657678098765\",\n" +
        "                \"label\": \"Compte Mozaïc\",\n" +
        "                \"operations\": [\n" +
        "                    {\n" +
        "                        \"amount\": \"-15,99\",\n" +
        "                        \"category\": \"leisure\",\n" +
        "                        \"date\": \"1644438769\",\n" +
        "                        \"id\": \"2\",\n" +
        "                        \"title\": \"Orange\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"order\": 3,\n" +
        "                \"product_code\": \"00007\",\n" +
        "                \"role\": 6\n" +
        "            }\n" +
        "        ],\n" +
        "        \"isCA\": 1,\n" +
        "        \"name\": \"CA Languedoc\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"accounts\": [\n" +
        "            {\n" +
        "                \"balance\": 45.84,\n" +
        "                \"contract_number\": \"32216549871\",\n" +
        "                \"holder\": \"Corinne Martin\",\n" +
        "                \"id\": \"09878900000\",\n" +
        "                \"label\": \"Compte de dépôt\",\n" +
        "                \"operations\": [\n" +
        "                    {\n" +
        "                        \"amount\": \"-1,99\",\n" +
        "                        \"category\": \"costs\",\n" +
        "                        \"date\": \"1588690878\",\n" +
        "                        \"id\": \"2\",\n" +
        "                        \"title\": \"Tenue de compte\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"amount\": \"-1,99\",\n" +
        "                        \"category\": \"costs\",\n" +
        "                        \"date\": \"1641760369\",\n" +
        "                        \"id\": \"3\",\n" +
        "                        \"title\": \"Tenue de compte\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"order\": 1,\n" +
        "                \"product_code\": \"00004\",\n" +
        "                \"role\": 1\n" +
        "            }\n" +
        "        ],\n" +
        "        \"isCA\": 0,\n" +
        "        \"name\": \"Boursorama\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"accounts\": [\n" +
        "            {\n" +
        "                \"balance\": 675.04,\n" +
        "                \"contract_number\": \"32216549871\",\n" +
        "                \"holder\": \"Jean Martin\",\n" +
        "                \"id\": \"3982997777\",\n" +
        "                \"label\": \"Compte Chèques\",\n" +
        "                \"operations\": [\n" +
        "                    {\n" +
        "                        \"amount\": \"-1331,44\",\n" +
        "                        \"category\": \"costs\",\n" +
        "                        \"date\": \"1644179569\",\n" +
        "                        \"id\": \"2\",\n" +
        "                        \"title\": \"Prêt immo\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"amount\": \"-53,20\",\n" +
        "                        \"category\": \"food\",\n" +
        "                        \"date\": \"1644784369\",\n" +
        "                        \"id\": \"2\",\n" +
        "                        \"title\": \"CB La Vie Claire\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"amount\": \"-10,00\",\n" +
        "                        \"category\": \"leisure\",\n" +
        "                        \"date\": \"1644611558\",\n" +
        "                        \"id\": \"3\",\n" +
        "                        \"title\": \"Prélèvement Spotify\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"amount\": \"-53,00\",\n" +
        "                        \"category\": \"trip\",\n" +
        "                        \"date\": \"1644870724\",\n" +
        "                        \"id\": \"4\",\n" +
        "                        \"title\": \"CB Billets SNCF\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"order\": 1,\n" +
        "                \"product_code\": \"00004\",\n" +
        "                \"role\": 1\n" +
        "            }\n" +
        "        ],\n" +
        "        \"isCA\": 0,\n" +
        "        \"name\": \"Banque Pop\"\n" +
        "    },\n" +
        "    {\n" +
        "        \"accounts\": [\n" +
        "            {\n" +
        "                \"balance\": 425.84,\n" +
        "                \"contract_number\": \"32216549871\",\n" +
        "                \"holder\": \"Corinne Martin\",\n" +
        "                \"id\": \"3982938\",\n" +
        "                \"label\": \"Compte de dépôt\",\n" +
        "                \"operations\": [\n" +
        "                    {\n" +
        "                        \"amount\": \"-1,99\",\n" +
        "                        \"category\": \"costs\",\n" +
        "                        \"date\": \"1644870724\",\n" +
        "                        \"id\": \"2\",\n" +
        "                        \"title\": \"Tenue de compte\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"amount\": \"-45,99\",\n" +
        "                        \"category\": \"leisure\",\n" +
        "                        \"date\": \"1644870724\",\n" +
        "                        \"id\": \"2\",\n" +
        "                        \"title\": \"Prélèvement Orange\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"order\": 1,\n" +
        "                \"product_code\": \"00004\",\n" +
        "                \"role\": 1\n" +
        "            }\n" +
        "        ],\n" +
        "        \"isCA\": 1,\n" +
        "        \"name\": \"CA Centre-Est\"\n" +
        "    }\n" +
        "]"): List<Bank> {
        val gson = Gson()
        val bankListType = object : TypeToken<List<Bank>>() {}.type
        return gson.fromJson(jsonString, bankListType)
    }
}