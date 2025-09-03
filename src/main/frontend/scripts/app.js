// Alpine.js 및 HTMX 로드
import Alpine from 'alpinejs';
import 'htmx.org';

// Alpine.js 글로벌 등록
window.Alpine = Alpine;

// Alpine.js 초기화
Alpine.start();

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