package uhack.contractor.model

/**
 * Created by piyush on 14/10/17.
 */




data class Builder(val Name: String, val Phone:String, val BuilderId:String,
                   val EmailId: String, val ProjectIDs: ArrayList<String>)


data class ContractorTemp(val contractorId:String="", val amount:Int=0, val duration:Int=0,
                          val time:String="",val Name:String="", val type:Int=0)
