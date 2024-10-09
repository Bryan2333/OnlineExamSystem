//获取试卷并跳转到添加题库
<template>
  <div class="exam">
    <el-table :data="pagination.records" border>
      <el-table-column fixed="left" prop="source" label="Exam Name" width="120"></el-table-column>
      <el-table-column prop="description" label="Description" width="180"></el-table-column>
      <el-table-column prop="institute" label="Institute" width="120"></el-table-column>
      <el-table-column prop="major" label="Major" width="160"></el-table-column>
      <el-table-column prop="grade" label="Grade" width="100"></el-table-column>
      <el-table-column prop="examDate" label="Exam dates" width="120"></el-table-column>
      <el-table-column prop="totalTime" label="Time" width="80"></el-table-column>
      <el-table-column prop="totalScore" label="Score" width="80"></el-table-column>
      <el-table-column prop="type" label="The type of test paper" width="120"></el-table-column>
      <el-table-column prop="tips" label="Tips for Candidates:" width="400"></el-table-column>
      <el-table-column fixed="right" label="operate" width="200">
        <template slot-scope="scope">
          <el-button @click="add(scope.row.paperId,scope.row.source)" type="primary" size="small">Add Questions to the Bank</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pagination.current"
        :page-sizes="[4, 8, 10, 20]"
        :page-size="pagination.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="pagination.total" class="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {}, //保存点击以后当前试卷的信息
      pagination: { //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 4 //每页条数
      },
    }
  },
  created() {
    this.getExamInfo()
  },
  methods: {
    getExamInfo() { //分页查询所有试卷信息
      this.$axios('/exam', {
        params: {
          pageNo: this.pagination.current,
          pageSize: this.pagination.size
        }
      }).then(res => {
        this.pagination = res.data.data
      }).catch(error => {
        console.log(error)
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val
      this.getExamInfo()
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val
      this.getExamInfo()
    },
    add(paperId, source) { //增加题库
      this.$router.push({path: '/addAnswerChildren', query: {paperId: paperId, subject: source}})
    }
  },
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
}
</style>
