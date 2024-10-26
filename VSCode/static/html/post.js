async function getData(){
    let rest = await fetch('http://gorest.co.in/public/v1/posts/');
    return await rest.json;
}