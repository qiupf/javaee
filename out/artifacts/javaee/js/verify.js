var code ="#code";
function createCode()
{
    code = "";
    var codeLength = 4;
    var checkCode = document.getElementById("checkCode");
    var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
    for(var i=0;i<codeLength;i++)
    {
        var charIndex = Math.floor(Math.random()*36);
        code +=selectChar[charIndex];
    }
    if(checkCode)
    {
        checkCode.className="code";
        checkCode.value = code;
        checkCode.blur();
    }
}
function userCheck()
{
    var username=document.getElementById("name");
    var password=document.getElementById("passwd");
    var inputCode = document.getElementById("validCode").value;
    if(username.value=="")
    {
        alert("用户名不能为空！");
        return false;
    }
    if(password.value=="")
    {
        alert("密码不能为空！");
        return false;
    }
    if(inputCode.length <=0)
    {
        alert("请输入验证码！");
        return false;
    }
    if(inputCode.toUpperCase() != code )
    {
        alert("验证码输入错误！");
        createCode();
        return false;
    }
}