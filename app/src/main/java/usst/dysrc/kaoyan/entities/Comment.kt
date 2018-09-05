package usst.dysrc.kaoyan.entities


import java.util.Date

class Comment {
    var commentId: Long? = null
    var postId: Long? = null
    var userId: Long? = null
    var userName: String? = null
    var content: String? = null
    var createDate: Date? = null
}
