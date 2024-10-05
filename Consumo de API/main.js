const apiURL = 'http://localhost:8080/clocks';

async function fechtData() {
    const response = await fetch(apiURL);
    const data = await response.json();
    console.log(data);
}

fechtData();