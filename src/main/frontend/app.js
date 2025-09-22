import Alpine from 'alpinejs'; // Alpine 전역 + 시작
import htmx from 'htmx.org'; // htmx 전역

window.Alpine = Alpine;
window.htmx = htmx;

Alpine.start();

// (선택) Spring Security CSRF 자동 부착
document.body.addEventListener('htmx:configRequest', (e) => {
    const t = document.querySelector('meta[name="_csrf"]')?.content;
    const h = document.querySelector('meta[name="_csrf_header"]')?.content;
    if (t && h) e.detail.headers[h] = t;
});