$(function() {
    $(".menu>li>a").click(function() {
        $(this).next("p").slideToggle(200);
        $(this).parent("li").siblings("li").children("p").slideUp(200);
    });
});
