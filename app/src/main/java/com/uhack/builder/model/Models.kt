package uhack.contractor.model

/**
 * Created by piyush on 14/10/17.
 */



data class Project(val Name: String, val Address:String,
                   val TotalBudget:Int, val CurrentExpenses:Int)

data class Builder(val Name: String, val Phone:String, val BuilderId:String,
                   val EmailId: String, val ProjectIDs: ArrayList<String>)

