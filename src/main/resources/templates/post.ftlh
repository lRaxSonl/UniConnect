<#import "base.ftlh" as base>

<@base.page>

<div class="container d-flex justify-content-left align-items-center" style="width: 60%; ">
    <img src="/assets/img/comment.jpeg" alt="Left Image 1" class="img-fluid" style="width: 36px; height: 34px;">
    <p style="font-size: 30px; font-weight: 500">0</p>
</div>


<div class="container d-flex justify-content-left align-items-center" style="width: 60%; ">
    <p style="font-size: 35px; font-weight: bold;">${post.title}</p>
</div>

<div class="container d-flex justify-content-center align-items-center" style="margin-top: 20px; width: 60%;">
    <p style="font-size: 20px; font-weight: 400;">${post.text}</p>
</div>
<div class="pink_container">
    <p></p>
</div>

<div>
    <form action="/post/comment-create" method="post">
        <h2>Add new comment</h2>
        <label for="text">Text:</label>
        <input type="text" name="text">
        <br>
        <br>
        <input type="hidden" name="post" value="${post.getId()}">
        <button type="submit">Publish Comment</button>
    </form>
</div>

<br><br><br>

<div class="comments">

    <#list comments as comment>
        <#if comment.post.id == post.id>
            <div class="card">
                <div class="card-body">

                    <#if comment.user??>
                        <h5 class="card-title">${comment.user.username}</h5>
                    <#else>
                            <h5 class="card-title">Anonymous</h5>
                    </#if>

                    <p class="card-text">${comment.text}</p>
                </div>
                <a href="/post/comment/delete/${comment.id}" style="color: red;" class="text_left"><p>Delete</p></a>
            </div>
        </#if>
    </#list>

</div>

</@base.page>