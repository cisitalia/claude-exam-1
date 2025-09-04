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

// 전역 JavaScript 함수들
window.app = {
  // 유틸리티 함수들
  utils: {
    formatDate: (date) => {
      return new Date(date).toLocaleDateString('ko-KR');
    },
    
    formatCurrency: (amount) => {
      return new Intl.NumberFormat('ko-KR', {
        style: 'currency',
        currency: 'KRW'
      }).format(amount);
    }
  },
  
  // 공통 Alpine.js 컴포넌트들
  components: {
    modal: () => ({
      show: false,
      open() {
        this.show = true;
      },
      close() {
        this.show = false;
      }
    }),
    
    dropdown: () => ({
      open: false,
      toggle() {
        this.open = !this.open;
      },
      close() {
        this.open = false;
      }
    })
  }
};

// HTMX 이벤트 리스너
document.addEventListener('htmx:beforeRequest', (event) => {
  console.log('HTMX Request:', event.detail);
});

document.addEventListener('htmx:afterRequest', (event) => {
  console.log('HTMX Response:', event.detail);
});

console.log('Frontend application initialized successfully!');