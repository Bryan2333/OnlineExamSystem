//显示学生成绩
<template>
  <div class="table">
    <p class="title">My score</p>
    <section class="content-el">
      <el-table ref="filterTable" :data="score" v-loading="loading">
        <el-table-column
          prop="answerDate"
          label="Exam dates"
          sortable
          width="300"
          column-key="answerDate"
          :filters="filter"
          :filter-method="filterHandler">
        </el-table-column>
        <el-table-column
          prop="subject"
          label="Course name"
          width="300"
          filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag>{{ scope.row.subject }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="etScore" label="Test scores" width="200"></el-table-column>
        <el-table-column label="Pass?" width="100">
          <template slot-scope="scope">
            <el-tag :type="scope.row.etScore>= 60 ? 'success' : 'danger'">
              {{ scope.row.etScore >= 60 ? "pass" : "Fail" }}
            </el-tag>
          </template>
        </el-table-column>
      </el-table>
      <el-row type="flex" justify="center" align="middle" class="pagination">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pagination.current"
          :page-sizes="[4,6,8,10]"
          :page-size="pagination.size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="pagination.total">
        </el-pagination>
      </el-row>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: { //分页后的留言列表
        current: 1, //当前页
        total: null, //记录条数
        size: 4 //每页条数
      },
      loading: false, //加载标识符
      score: [], //学生成绩
      filter: null //过滤参数
    }
  },
  created() {
    this.getScore()
    this.loading = true //数据加载则遮罩表格
  },
  methods: {
    getScore() {
      let studentId = this.$cookies.get("cid")
      this.$axios('/score', {
        params: {
          pageNo: this.pagination.current,
          pageSize: this.pagination.size,
          studentId: studentId
        }
      }).then(res => {
        if (res.data.code === 200) {
          this.loading = false; //数据加载完成去掉遮罩
          this.score = res.data.data.records;
          this.pagination = res.data.data;
          let mapVal = this.score.map((element, index) => { //通过map得到 filter:[{text,value}]形式的数组对象
            let newVal = {}
            newVal.text = element.answerDate
            newVal.value = element.answerDate
            return newVal
          })
          let hash = []
          this.filter = mapVal.reduce((item, next) => { //对新对象进行去重操作
            hash[next.text] ? '' : hash[next.text] = true && item.push(next);
            return item
          }, [])
        }
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val
      this.getScore()
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val
      this.getScore()
    },
    formatter(row, column) {
      return row.address;
    },
    filterTag(value, row) {
      return row.tag === value;
    },
    filterHandler(value, row, column) {
      const property = column["property"];
      return row[property] === value;
    }
  }
};
</script>

<style lang="less" scoped>
.pagination {
  padding-top: 20px;
}

.table {
  width: 980px;
  margin: 0 auto;

  .title {
    margin: 20px;
  }

  .content-el {
    background-color: #fff;
    padding: 20px;
  }
}
</style>
