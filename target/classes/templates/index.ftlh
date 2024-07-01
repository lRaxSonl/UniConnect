<#import "base.ftlh" as base>

<@base.page>

<div class="container-fluid">
    <div class="d-flex flex-row mb-3">

        <#list posts as post>
            <div class="card" style="width: 18rem; background-color: #cccccc">
                <#if post?has_content && post.filename?has_content>
                    <a href="/post/${post.id}"><img src="${post.filename}" class="card-img-top" alt="..."></a>

                <#else>
                    <a href="/post/${post.id}"><img src="assets/img/cool.jpeg" class="card-img-top" alt="..."></a
                </#if>
                <div class="card-body">
                    <a href="/post/${post.id}" style="color: black;">
                        <h5 class="card-title textShadowAnimation">${post.title}</h5>
                    </a>
                </div>
                <ul class="list-group list-group-flush">
                    <div class="row justify-content-between align-items-center">
                        <div class="col-md-4">
                            <h8 class="card-title">${post.date}</h8>
                        </div>
                        <div class="col-md-4 text-right"> <!-- Изменение класса для правого выравнивания -->
                            <div class="row justify-content-end align-items-center">
                                <!-- Добавление вложенного ряда для выравнивания элементов внутри -->
                                <div class="col-auto">
                                    <img src="/assets/img/comment.png" alt="Left Image 1"
                                         class="img-fluid mb-0" style="width: 29px; height: 27px;">
                                </div>
                                <div class="col-auto">
                                    <h5 class="card-title mb-0"></h5>
                                    <!-- Добавление класса mb-0 для удаления отступа у заголовка -->
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2 text-right">
                            <div class="row justify-content-end align-items-center">
                                <div class="col-auto">
                                    <form action="/post/favorite-create" method="post">
                                        <br>
                                        <br>
                                        <input type="hidden" name="post" value="${post.getId()}">
                                        <button type="submit" style="border: none; background: none;">
                                            <img src="/assets/img/follow.png" alt="Left Image 1" class="img-fluid"
                                                 style="width: 21px; height: 25px;" id="followImage">
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a href="/post/delete/${post.id}" style="color: red;">Delete</a>
                </ul>
            </div>
        </#list>

    </div>
</div>

</div>
</body>

</html>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        let followImage = document.getElementById("followImage");
        let isFollowActive = false;

        followImage.addEventListener("click", function () {
            if (isFollowActive) {
                followImage.src = "/assets/img/follow.png";
            } else {
                followImage.src = "/assets/img/follow-activate.png";
            }
            isFollowActive = !isFollowActive; // Переключение состояния
        });
    });

    function submitForm() {
        document.getElementById("searchForm").submit();
    }
</script>

</@base.page>