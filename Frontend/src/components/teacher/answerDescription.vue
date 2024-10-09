<!-- 题库管理功能介绍 -->
<template>
  <section class="description">
    <p class="title">Overview of Question Database Administration Features</p>
    <p class="content">The design of question bank tables differs from regular data table design. It is divided into three tables: Multiple Choice Question Bank table, Fill-in-the-Blank Question Bank table, and True/False Question Bank table. Each table stores respective types of question banks. These are linked to the questions through an intermediate table. This configuration forms a complete exam paper.</p>
  </section>
</template>

<style lang="less" scoped>
.description {
  margin-left: 40px;
  .title {
    font-size: 22px;
    font-weight: 400;
    color: rgb(31, 47, 61);
  }
  .content {
    width: 600px;
    background-color: #FAF5F2;
    padding: 16px 32px;
    border-radius: 4px;
    border-left: 5px solid #FDC8C8;
    margin: 20px 0px;
  }
}
</style>
