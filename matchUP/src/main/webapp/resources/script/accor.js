 $(function() {
        $(".menu>li>a").click(function() {
            // 클릭한 메뉴의 부모 li 요소를 찾습니다.
            var parentLi = $(this).parent("li");

            // 다른 li 요소의 하위 p 요소는 모두 닫습니다.
            $(".menu>li").not(parentLi).children("p").slideUp(200);

            // 클릭한 메뉴의 하위 p 요소를 토글합니다.
            $(this).next("p").slideToggle(200);
        });
    });