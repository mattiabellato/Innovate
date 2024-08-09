const prevButton = document.getElementById('prev');
const nextButton = document.getElementById('next');
const carouselInner = document.querySelector('.carousel-inner');
let currentIndex = 0;

prevButton.addEventListener('click', () => {
    if (currentIndex > 0) {
        currentIndex--;
        updateCarousel();
    }
});

nextButton.addEventListener('click', () => {
    if (currentIndex < 2) { // Total items - 1
        currentIndex++;
        updateCarousel();
    }
});

function updateCarousel() {
    const offset = -currentIndex * 220; // Item width + margin
    carouselInner.style.transform = `translateX(${offset}px)`;
}
