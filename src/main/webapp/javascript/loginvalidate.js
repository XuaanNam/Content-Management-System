var email = document.querySelector('#email');
email.addEventListener('blur', function(){
    var e_tick = document.querySelector('.e_tick');
    var e_error = document.querySelector('.e_error');
    var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(regex.test(email.value) && email.value.length >=5){
        email.style.border = "1.5px solid green";
        e_error.style.display = 'none';
        e_tick.style.display = 'block';
    }
    else{
        email.style.border = "1.5px solid red";
        e_error.style.display = 'block';
        e_tick.style.display = 'none';
    }
})

var pass = document.querySelector('#pass');
pass.addEventListener('blur', function(){
    var p_tick = document.querySelector('.p_tick');
    var p_error = document.querySelector('.p_error');
    if(pass.value.length >= 8 && pass.value.length <=30){
        pass.style.border = "1.5px solid green";
        p_error.style.display = 'none';
        p_tick.style.display = 'block';
    }
    else{
        pass.style.border = "1.5px solid red";
        p_error.style.display = 'block';
        p_tick.style.display = 'none';
    }
})

function validate(){
    if(email.value.length == 0 || pass.value.length == 0){
        document.querySelector('.mess').innerHTML = 'Please fill empty fields';
	
        return false;
    }
    else{
		return true;
    }
}
