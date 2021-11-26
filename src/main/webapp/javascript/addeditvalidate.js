/**
 * 
 */
// Đối tượng 'Validator'
function Validator(options) {
    // Hàm thực hiện validate
    function validate(inputElement, rule) {
        var errorElement = inputElement.parentElement.querySelector(
            options.errorSelector
        );
        var errorMessage = rule.test(inputElement.value);
        if (errorMessage) {
            errorElement.innerText = errorMessage;
            inputElement.parentElement.classList.add("invalid");
        } else {
            errorElement.innerText = "";
            inputElement.parentElement.classList.remove("invalid");
        }
    }
    // Lấy element của form cần validate
    var formElement = document.querySelector(options.form);

    if (formElement) {
        formElement.onsubmit = function(e) {
            //e.preventDefault();

            //    Thực hiện lặp qua từng rules và validate
            options.rules.forEach(function(rule) {
                var inputElement = formElement.querySelector(rule.selector);
                validate(inputElement, rule);
            });
        };

        // Lặp qua mỗi rules và xử lí(lắng nghe sự kiện blur, input)
        options.rules.forEach(function(rule) {
            //Lưu lại các rules cho mỗi input

            var inputElement = formElement.querySelector(rule.selector);

            if (inputElement) {
                //Xử lý trường hợp blur ra khỏi input
                inputElement.onblur = function() {
                    validate(inputElement, rule);
                };

                //   Xử lý mỗi khi người dùng nhập vào input
                inputElement.oninput = function() {
                    var errorElement = inputElement.parentElement.querySelector(
                        options.errorSelector
                    );
                    errorElement.innerText = "";
                    inputElement.parentElement.classList.remove("invalid");
                };
            }
        });
    }
}

//Định nghĩa các rules
// Nguyên tắc của các rules:
// 1.Khi có lỗi thì trả ra message lỗi
// 2.Khi không có lỗi thì không trả ra gì cả (undefined)
Validator.checkLength = function(selector, min, max, message) {
    return {
        selector: selector,
        test: function(value) {
            return value.length >= min && value.length <= max ?
                undefined :
                message ||
                "Required and must be of length " + min + " to " + max + "!";
        },
    };
};

Validator.isPhoneNo = function(selector, min, max, message) {
    return {
        selector: selector,
        test: function(value) {
            var phoneno = /^\d{10}$/;
            return phoneno.test(value) && value.length >= min && value.length <= max ?
                undefined :
                message ||
                "Required number and must be of length " + min + " to " + max + "!";
        },
    };
};
// Validator.isRequired = function(selector, message) {
//     return {
//         selector: selector,
//         test: function(value) {
//             return value.trim() ? undefined : message || "Vui lòng nhập trường này";
//         },
//     };
// };

// Validator.isEmail = function(selector, message) {
//     return {
//         selector: selector,
//         test: function(value) {
//             var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//             return regex.test(value) ?
//                 undefined :
//                 message || "Trường này phải là email";
//         },
//     };
// };

// Validator.minLength = function(selector, min, message) {
//     return {
//         selector: selector,
//         test: function(value) {
//             return value.length >= min ?
//                 undefined :
//                 message || "Vui lòng nhập tối thiểu " + min + " kí tự";
//         },
//     };
// };

// Validator.maxLength = function(selector, max, message) {
//     return {
//         selector: selector,
//         test: function(value) {
//             return value.length <= max ?
//                 undefined :
//                 message || "Vui lòng nhập tối đa " + max + " kí tự";
//         },
//     };
// };

// Validator.isConfirmed = function(selector, getConfirmValue, message) {
//     return {
//         selector: selector,
//         test: function(value) {
//             return value === getConfirmValue() ?
//                 undefined :
//                 message || "Giá trị không chính xác";
//         },
//     };
// };