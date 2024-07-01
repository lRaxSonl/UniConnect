<#import "base.ftlh" as base>

<@base.page>

<form action="/post/create-now" method="post" enctype="multipart/form-data">
    <h2>Create a New Article</h2>
    <label for="title">Article Title:</label>
    <input type="text" id="title" name="title">

    <label for="file">Add an Image:</label>
    <input type="file" id="file" name="file">

    <label for="text">Article Text:</label>
    <textarea id="text" name="text" rows="6"></textarea>

    <button type="submit">Publish Article</button>
</form>

</@base.page>