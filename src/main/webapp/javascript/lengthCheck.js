function validate() {
    var fname_input = document.getElementById("fname-box");
    var lname_input = document.getElementById("lname-box");
    var email_input = document.getElementById("email-box");
    var phone_input = document.getElementById("phone-box");
    var descript_input = document.getElementById("description-box");
    if (
        fname_input.value.length >= 3 &&
        fname_input.value.length <= 30 &&
        lname_input.value.length >= 3 &&
        lname_input.value.length <= 30 &&
        phone_input.value.length >= 9 &&
        phone_input.value.length <= 13 &&
        descript_input.value.length <= 200
    ) {
        return true;
    }
    alert(
        "Hãy nhập dữ liệu đúng với yêu cầu sau:\n 30 <= First Name && Last Name <= 30 \n 9 <= Phone <= 13 \n Description <= 200"
    );
    return false;
}