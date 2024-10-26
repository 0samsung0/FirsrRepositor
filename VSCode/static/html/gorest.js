async function getData(){
    let rest = await fetch('https://api.open-meteo.com/v1/forecast');
    return rest.json;
}
console.log(rest);
let list = await getData();

async function createList(data) {
    let ul = document.createElement('ul');
    for (const item of data) {
      let li = document.createElement('li');
      li.textContent = item.title;
      a.href = 'post.html?post_id=' + item.id;
      li.append(a);
      ul.append(li);
    }
    document.body.append(ul);
  }
  
  async function getDataAndCreateList() {
    let data = await getData();
    createList(data);
  }
  
  getDataAndCreateList();