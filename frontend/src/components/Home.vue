<template>
  <div class="home">
    <header class="header">
      <h1>Welcome to Global Home</h1>
    </header>
    <main>
      <p>This is the main page of GlobalHome application. Enjoy your stay!</p>
    </main>
    <footer class="footer">
      <p>&copy; 2024 GlobalHome Inc.</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'Home'
};
</script>

<style scoped>
.home {
  text-align: center;
}

.header {
  background-color: #4CAF50;
  color: white;
  padding: 20px;
}

.footer {
  background-color: #f1f1f1;
  padding: 10px;
  position: fixed;
  width: 100%;
  bottom: 0;
}

main {
  margin: 20px;
}
</style>