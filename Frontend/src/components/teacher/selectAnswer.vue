//查询所有题库
<template>
  <div class="exam">
    <el-scrollbar style="height: 560px;">
      <el-table :data="pagination.records" border :row-class-name="tableRowClassName">
        <el-table-column fixed="left" prop="subject" label="Subject" width="180"></el-table-column>
        <el-table-column prop="question" label="Question"></el-table-column>
        <el-table-column prop="section" label="Chapter" width="200"></el-table-column>
        <el-table-column prop="type" label="Type" width="200"></el-table-column>
        <el-table-column prop="score" label="Score" width="150"></el-table-column>
        <el-table-column prop="level" label="Difficulty" width="133"></el-table-column>
      </el-table>
    </el-scrollbar>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[15, 20, 30]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    ></el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 15 //每页条数
      }
    };
  },
  created() {
    this.getAnswerInfo();
  },
  methods: {
    getAnswerInfo() {
      //分页查询所有试卷信息
      this.$axios(
        `/answer`, {
          params: {
            pageNo: this.pagination.current,
            pageSize: this.pagination.size
          }
        }
      )
        .then(res => {
          this.pagination = res.data.data;
          console.log(res);
        })
        .catch(error => {
        });
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    },
    tableRowClassName({row, rowIndex}) {
      if (rowIndex % 2 === 0) {
        return "warning-row";
      } else {
        return "success-row";
      }
    }
  }
};
</script>
<style lang="less" scoped>
.exam {
  padding: 0 40px;

  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .edit {
    margin-left: 20px;
  }

  .el-table tr {
    background-color: #DD5862 !important;
  }
}

.el-table .warning-row {
  background: #000 !important;

}

.el-table .success-row {
  background: #DD5862;
}

</style>
