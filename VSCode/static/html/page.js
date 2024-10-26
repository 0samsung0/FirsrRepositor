function firstEl(tag, text) {
  let elements = [];
  for (let textt of text) {
    let element = document.createElement(tag);
    element.innerText = textt;
    element.href = 'http://' + textt + '.com'; // Установка ссылки
    elements.push(element); // Добавляем элемент в массив
  }
  return elements;
}

const fixLink = (a) => {
  const fixArr = [];
  for (let b of a) {
    fixArr.push('http://' + b + '.com'); // Используем push для добавления
  }
  return fixArr;
}

const brokenLinks = ['vk', 'facebook', 'linkedin'];
let fixxLink = fixLink(brokenLinks);

const El = firstEl('a', fixxLink);
for (let el of El) {
  document.body.append(el); // Добавляем каждый элемент
}













function hello(){
  console.log('Hello');
}
function world(){
  console.log('world');
}
function names(){
  console.log('Name is = ');
}
function age(){
  console.log('age');
}

async function fly(){
  await new Promise((resolve, reject)=>setTimeout(resolve, 3000));
  console.log('Flyyyyyyy');
}
let x = await fly();
console.log(x);