<#import "base.ftlh" as base>

<@base.page>

<section class="posts">
    <h1 class="text-black text-center">Favorite post</h1>
    <div class="container">
        <div class="row justify-content-center">
            <#list favorites as favorite>
                <div class="col-md-4">
                    <div class="post">
                        <#if favorite.post?has_content && favorite.post.filename?has_content>
                            <a href="/post/${favorite.post.id}">
                                <img src="${favorite.post.filename}" alt="post1">
                            </a>
                        <#else>
                            <a href="/post/${favorite.post.id}">
                                <img src="/assets/img/cool.jpeg" alt="post1">
                            </a>
                        </#if>
                        <a href="/post/${favorite.post.id}" style="color: black;">
                            <h3>${favorite.post.title}</h3>
                        </a>
                        <a href="/post/delete/${favorite.post.id}" style="color: red;">Post delete</a>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</section>

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

</script>

</@base.page>