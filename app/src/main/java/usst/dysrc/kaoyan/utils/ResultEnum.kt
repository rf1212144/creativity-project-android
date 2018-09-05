package usst.dysrc.kaoyan.utils

enum class ResultEnum constructor(val code: Int?, val message: String) {
    LOGIN_PSW_ERROR(1, "密码错误"),
    LOGIN_ERROR(2, "没有该用户"),
    LOGIN_SUCCESS(3, "登陆成功"),
    ACCOUNT_EXIST(4, "账号已存在"),
    REGISTER_SUCCESS(5, "注册成功"),
    CHANGE_USER_INFO_FAILED(6, "changeUserInfo failed"),
    CHANGE_USER_INFO_SUCCESS(7, "changeUserInfo success"),
    CREATE_POST_FAILED(8, "failed"),
    CREATE_POST_SUCCESS(9, "create post success"),
    ADMIRE_FAILED(10, "FAILED"),
    ADMIRE_SUCCESS(11, "admire success"),
    DELETE_POST_FAILED(12, "failed"),
    DELETE_POST_SUCCESS(13, "delete post success"),
    INCREASE_COMMENT_FAILED(14, "increase comment failed"),
    INCREASE_COMMENT_SUCCESS(15, "INCREASE COMMENT SUCCESS"),
    COLLECT_POST_FAILED(16, "FAILED"),
    COLLECT_POST_COLLECTED(17, "collected post"),
    COLLECT_POST_SUCCESS(18, "collect success")
}