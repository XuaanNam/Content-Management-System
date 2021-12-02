var uname = document.querySelector('#uname');
uname.addEventListener('blur', function(){
    var u_tick = document.querySelector('.u_tick');
    var u_error = document.querySelector('.u_error');
    if(uname.value.length >= 3 && uname.value.length <=30){
        uname.style.border = "1.5px solid green";
        u_error.style.display = 'none';
        u_tick.style.display = 'block';
    }
    else{
        uname.style.border = "1.5px solid red";
        u_error.style.display = 'block';
        u_tick.style.display = 'none';
    }
})
var email = document.querySelector('#email');
email.addEventListener('blur', function(){
    var e_tick = document.querySelector('.e_tick');
    var e_error = document.querySelector('.e_error');
    var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(regex.test(email.value) && email.value.length >=15){
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

var repass = document.querySelector('#repass');
repass.addEventListener('blur', function(){
    var rp_tick = document.querySelector('.rp_tick');
    var rp_error = document.querySelector('.rp_error');
    if(repass.value.length >= 8 && pass.value.length <=30){
        repass.style.border = "1.5px solid green";
        rp_error.style.display = 'none';
        rp_tick.style.display = 'block';
		
    }
    else{
        repass.style.border = "1.5px solid red";
        rp_error.style.display = 'block';
        rp_tick.style.display = 'none';
    }
})

function validate(){
	console.log(email.value.length);
	console.log("ok");
    if(email.value.length == 0 || uname.value.length == 0 || pass.value.length == 0 || repass.value.length == 0){
        document.querySelector('.mess').innerHTML = 'Please fill empty fields';
        return false;
    }
	else if(uname.value.length < 3){
        document.querySelector('.mess').innerHTML = 'Username must be at least 3 characters';
		return false;
	}
	else if(email.value.length < 15){
        document.querySelector('.mess').innerHTML = 'Email must be at least 5 characters';
		return false;
	}
	else if(pass.value.length < 8){
        document.querySelector('.mess').innerHTML = 'Password must be at least 8 characters';
		return false;
	}
	else if(pass.value != repass.value){
        document.querySelector('.mess').innerHTML = 'Incorect confirm password';
		return false;
	}
    return true;
}