package uhack.contractor.model

/**
 * Created by nimit on 14/10/17.
 */




data class Builder(val Name: String, val Phone:String, val BuilderId:String,
                   val EmailId: String, val ProjectIDs: ArrayList<String>)


data class Transaction(val transactionID: String, val inventoryID: String,
                       val comment: String, val type:Int, val creatorID:String, val delta:Int)