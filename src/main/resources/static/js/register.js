
function fn_register(){
    //alert("test"); 페이지 연결 확인
    // 유효성검사
    let id = document.querySelector("#id");
    if(id.value == ''){
        alert('아이디를 입력해주세요');
        return;
    }
    let name = document.querySelector("#name");
    if(name.value == ''){
        alert('이름을 입력해주세요');
        return;
    }
    let pw = document.querySelector("#pw");
    if(pw.value == ''){
        alert('비밀번호를 입력해주세요');
        return;
    }
    // 정규식을 이용하여 비밀번호의 패턴을 체크
    // 정규식 패턴을 작성 할때에는 /로 감싸줍니다.
    let regexp = /^(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;
    // test()메서드를 이용하여 정규식 패턴에 일치 하는지 확인 
    if(!regexp.test(pw.value)){
        alert('비밀번호를 영어 대소문자와 특수문자로 8자리 이상 12자리 이하로 입력 해주세요');
        return;
    }

    let pw_check = document.querySelector("#pw_check");
    if(pw.value != pw_check.value){
        alert('비밀번호가 일치하지 않습니다. \n비밀번호를 확인해주세요');
        return;
    }
    // 폼 전송 ( 폼이름.submit() )
    registerForm.submit();
}