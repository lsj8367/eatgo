(async () => {
    const url = 'http://localhost:8080/restaurants'
    const response = await fetch(url);
    const restaurants = await response.json();

    const element = document.getElementById('app'); // id가 app인애한테 적용시킨다
    element.innerHTML = `
        ${restaurants.map(restaurant => `
            <p>
            ${restaurant.id}
            ${restaurant.name}
            ${restaurant.address}
            </p>
        `).join('')}
    `;
    //JSON.stringify(restaurants);
})();