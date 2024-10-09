// 给我留言页面
<template>
  <div id="message">
    <div class="title">Leave me a message</div>
    <div class="wrapper">
      <div class="title1">
        <el-input
          placeholder="Message title"
          v-model="title"
          clearable>
        </el-input>
      </div>
      <div class="content">
        <el-input
          type="textarea"
          :rows="3"
          placeholder="Message"
          v-model="content"
          clearable>
        </el-input>
      </div>
      <div class="btn">
        <el-button type="primary" @click="submit()">Submit a message</el-button>
      </div>
      <div class="all">
        <ul class="msglist">
          <li class="list"
          @mouseenter="enter(index)"
          @mouseleave="leave(index)"
          v-for="(data,index) in msg" :key="index"
          >
            <p class="title"> <i class="iconfont icon-untitled33"></i>{{data.title}}</p>
            <p class="content">{{data.content}}</p>
            <p class="date"><i class="iconfont icon-date"></i>{{data.time}}</p>
            <div v-for="(replyData,index2) in data.replies" :key="index2">
              <p class="comment"><i class="iconfont icon-huifuxiaoxi"></i>{{replyData.reply}}</p>
            </div>
            <span class="replay" @click="reply(data.id)" v-if="flag && index === current">Comment</span>
          </li>
        </ul>
      </div>
      <div class="pagination">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pagination.current"
          :page-sizes="[4,6,8,10]"
          :page-size="pagination.size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="pagination.total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  // name: 'message'
  data() {
    return {
      flag: false,
      current: 0,
      title: "",
      content: "",
      pagination: { //分页后的留言列表
        current: 1, //当前页
        total: null, //记录条数
        size: 4 //每页条数
      },
      msg: []
    }
  },
  created() {
    this.getMsg()
  },
  // watch: {

  // },
  methods: {
    getMsg() {
      this.$axios(`/message`, {
        params: {
          pageNo: this.pagination.current,
          pageSize: this.pagination.size
        }
      }).then(res => {
        let status = res.data.code
        if(status === 200) {
          this.msg = res.data.data.records
          this.pagination = res.data.data
        }
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val
      this.getMsg()
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val
      this.getMsg()
    },
    submit() {
      let date = new Date()
      if(this.title.length === 0 || this.content.length === 0) { //非空判断
        this.$message({
          type: 'error',
          message: 'The title or content of the message cannot be empty',
        })
       } else {
      this.$axios({
        url: "/message",
        method: "post",
        data: {
          title: this.title,
          content: this.content,
          time: date
        }
      }).then(res => {
        let code = res.data.code
        if(code === 200) {
          this.$message({
            type: "success",
            message: "Message successful"
          })
        }
        this.getMsg()
      })
    }
      this.title = ""
      this.content = ""
      this.getMsg()
    },
    reply(messageId) { //回复留言功能
      this.$prompt('Reply to the message', 'prompt', {
        confirmButtonText: 'Are you sure',
        cancelButtonText: 'Cancel',
        inputPattern: /^[\s\S]*.*[^\s][\s\S]*$/,
        inputErrorMessage: 'The reply cannot be empty'
      }).then(({ value }) => {
        let date = new Date()
        console.log(messageId)
        this.$axios({
          url: '/reply',
          method: 'post',
          data: {
            reply: value,
            replyTime: date,
            messageId: messageId
          }
        }).then(res => {
          this.getMsg()
        })
        this.$message({
          type: 'success',
          message: 'The reply was successful'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'De-enter'
        });
      });
    },
    enter(index) {
      this.flag = true
      this.current = index
    },
    leave(index) {
      this.flag = false;
      this.current = index;
    }
  }
}
</script>

<style lang="less" scoped>
.pagination {
  display: flex;
  justify-content: center;
}
#message {
  width: 980px;
  margin: 0 auto;
}
.title {
  margin: 20px;
}
.content {
  padding: 20px 0px;
}
#message  {
  .btn {
   padding-bottom: 20px;
  }
  .all {
    .date {
      color: rgb(80, 157, 202);
      line-height: 45px;
      font-size: 13px;
    }
    .list {
      background-color: #eee;
      padding:10px;
      border-radius: 4px;
      margin: 10px 0px;
      position: relative;
      transition: all .3s ease;
      .title {
        color: #5f5f5f;
        margin: 0px;
        font-size: 13px;
        line-height: 30px;
      }
      .content {
        padding: 0px;
      }
      .icon-untitled33 {
        font-size: 13px;
        margin-right: 4px;
      }
      .icon-date {
        font-size: 13px;
        margin-right: 4px;
        color: rgb(80, 157, 202);
      }
      .replay {
        position: absolute;
        right: 30px;
        bottom: 15px;
        color: tomato;
        cursor: pointer;
        transition: all .3s ease;
      }
      .comment {
        margin:-7px 0px;
        padding-bottom: 12px;
        font-size: 13px;
        color: #28b2b4;
        i {
          margin-right: 4px;
        }
      }
    }
  }
}
#message .wrapper {
  background-color: #fff;
  padding: 20px;

}
</style>
