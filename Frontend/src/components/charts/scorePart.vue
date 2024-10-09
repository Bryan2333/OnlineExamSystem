<template>
  <div class="part">
    <div class="box" ref="box"></div>
    <div v-if="isNull">
      <span>No one has taken this exam yet, so please remind students to take the exam.</span>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isNull: false, //是否有成绩标志位
      name: null,
      category: { //保存分数段
        '90分及以上': 0,
        '80-89分': 0,
        '70-79分': 0,
        '60-69分': 0,
        '60分以下': 0,
      }
    }
  },
  created() {
    this.getScoreInfo()

  },
  methods: {
    getScoreInfo() {
      let examCode = this.$route.query.examCode
      this.name = this.$route.query.source
      this.$axios(`/scores/${examCode}`).then(res => {
        let data = res.data.data
        if (data.length > 0) {
          let box = this.$refs['box']
          let charts = this.$echarts.init(box)
          data.forEach(element => {
            switch (element.etScore / 10) {
              case 10:
              case 9:
                this.category["90分及以上"]++
                break
              case 8:
                this.category['80-89分']++
                break
              case 7:
                this.category["70-79分"]++
                break
              case 6:
                this.category['60-69分']++
                break
              default:
                this.category['60分以下']++
            }
          });
          let option = {
            title: {
              text: `${this.name}分数段图`,
              subtext: '分数段饼图',
              x: 'center'
            },
            tooltip: {
              trigger: 'item',
              formatter: "{a}：{b} <br/> {c} people ({d}%)"
            },
            legend: {
              orient: 'vertical',
              left: 'left',
              data: ['Scored 90 or above', '80-89', '70-79', '60-69', 'Scored below 60']
            },
            series: [
              {
                name: 'Mark Range',
                type: 'pie',
                radius: '35%',
                center: ['50%', '35%'],
                data: [
                  {value: this.category['90分及以上'], name: 'Scored 90 or above'},
                  {value: this.category['80-89分'], name: '80-89'},
                  {value: this.category['70-79分'], name: '70-79'},
                  {value: this.category['60-69分'], name: '60-69'},
                  {value: this.category['60分以下'], name: 'Scored below 60'}
                ],
                itemStyle: {
                  emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
                }
              }
            ]
          };
          charts.setOption(option)
        } else {
          this.isNull = true
        }
      })
    }
  },

}
</script>

<style lang="less" scoped>
.part {
  .box {
    width: 800px;
    height: 800px;
    margin-left: 40px;
  }
}
</style>


