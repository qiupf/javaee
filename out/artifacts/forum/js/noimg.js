function nofind() {
    var img = event.srcElement;
    img.src = "upload/default.jpg"; //替换的图片
    img.onerror = null; //控制不要一直触发错误
}
