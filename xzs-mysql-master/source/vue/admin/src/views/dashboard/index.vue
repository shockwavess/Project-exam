<template>
  <div class="dashboard-container">
    <el-row class="echarts-line">
      <div id="main5" style="width: 100%;height:500px;" v-loading="loading"/>
    </el-row>
    <el-row class="echarts-line">
      <div id="main7" style="width: 100%;height:70px;" v-loading="loading"/>
    </el-row>
    <el-row class="echarts-line">
      <div id="main" style="width: 100%;height:400px;" v-loading="loading"/>
    </el-row>



    <el-row class="echarts-line">
      <div id="main2" style="width: 65%;height:400px;float: left" v-loading="loading"/>

      <div id="bie" style="width: 35%;height:400px;float: right" v-loading="loading"/>
    </el-row>


    <el-row class="echarts-line">
      <div id="main3" style="width: 100%;height:400px;" v-loading="loading"/>
    </el-row>


    <el-row class="echarts-line">
      <div id="main6" style="width: 100%;height:100px;" v-loading="loading"/>
    </el-row>
  </div>
</template>

<script>
import resize from './components/mixins/resize'
import * as echarts from 'echarts'
import 'echarts-gl';

export default {
  mixins: [resize],
  components: {

  },
  data () {

  },
  mounted () {
    this.intbie();
    this.intmain();
    this.intmain2();
    this.intmain3();

    this.intmain5();
  },
  methods: {
    intbie () {
      var chartDom = document.getElementById('bie')
      var myChart = echarts.init(chartDom)
      var option

      option = {
        title: {
          text: '成绩分布图',
          subtext: '随机百位学生',
          left: 'center'
        },
        toolbox:{
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: '50%',
            data: [
              { value: 30, name: '成绩优秀' },
              { value: 23, name: '成绩良' },
              { value: 20, name: '成绩中' },
              { value: 10, name: '成绩合格' },
              { value: 7, name: '成绩不合格' }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      }

      option && myChart.setOption(option)
    },
    intmain() {
      var app = {};

      var chartDom = document.getElementById('main');
      var myChart = echarts.init(chartDom);
      var option;

      const posList = [
        'left',
        'right',
        'top',
        'bottom',
        'inside',
        'insideTop',
        'insideLeft',
        'insideRight',
        'insideBottom',
        'insideTopLeft',
        'insideTopRight',
        'insideBottomLeft',
        'insideBottomRight'
      ];
      app.configParameters = {


        rotate: {
          min: -90,
          max: 90
        },
        align: {
          options: {
            left: 'left',
            center: 'center',
            right: 'right'
          }
        },
        verticalAlign: {
          options: {
            top: 'top',
            middle: 'middle',
            bottom: 'bottom'
          }
        },
        position: {
          options: posList.reduce(function (map, pos) {
            map[pos] = pos;
            return map;
          }, {})
        },
        distance: {
          min: 0,
          max: 100
        }
      };
      app.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
          const labelOption = {
            rotate: app.config.rotate,
            align: app.config.align,
            verticalAlign: app.config.verticalAlign,
            position: app.config.position,
            distance: app.config.distance
          };
          myChart.setOption({
            series: [
              {
                label: labelOption
              },
              {
                label: labelOption
              },
              {
                label: labelOption
              },
              {
                label: labelOption
              }
            ]
          });
        }
      };
      const labelOption = {
        show: true,
        position: app.config.position,
        distance: app.config.distance,
        align: app.config.align,
        verticalAlign: app.config.verticalAlign,
        rotate: app.config.rotate,
        formatter: '{c}  {name|{a}}',
        fontSize: 16,
        rich: {
          name: {}
        }
      };
      option = {
        title: {
          text: '学生四科成绩分析图',
          subtext: '随机千位学生',
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {
          data: ['最高分', '最低分', '平均分']
        },
        toolbox: {
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar', 'stack'] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        xAxis: [
          {
            type: 'category',
            axisTick: { show: false },
            data: ['大学英语', '心理测试', '大学数学', '大学政治']
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '最高分',
            type: 'bar',
            barGap: 0,
            label: labelOption,
            emphasis: {
              focus: 'series'
            },
            data: [92, 99, 98, 97]
          },
          {
            name: '最低分',
            type: 'bar',
            label: labelOption,
            emphasis: {
              focus: 'series'
            },
            data: [43, 34, 44, 47]
          },
          {
            name: '平均分',
            type: 'bar',
            label: labelOption,
            emphasis: {
              focus: 'series'
            },
            data: [68, 69, 70, 71]
          }
        ]
      };

      option && myChart.setOption(option);
    },
    intmain2(){
      var chartDom = document.getElementById('main2');
      var myChart = echarts.init(chartDom);
      var option;

      option = {
        title:{
          text:'心理测试成绩分布图',
          subtext:'千位学生的心理测试成绩',
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        toolbox: {
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        legend: {
          data: [
            'Direct',
            'Marketing',
            'Search Engine',
            'Email',
            'Union Ads',
            'Video Ads',
            'Baidu',
            'Google',
            'Bing',
            'Others'
          ]
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            selectedMode: 'single',
            radius: [0, '30%'],
            label: {
              position: 'inner',
              fontSize: 14
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1548, name: '大学一年级' },
              { value: 775, name: '大学二年级' },
              { value: 679, name: '大学三年级', selected: true }
            ]
          },
          {
            name: '成绩分布',
            type: 'pie',
            radius: ['45%', '60%'],
            labelLine: {
              length: 30
            },
            label: {
              formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
              backgroundColor: '#F6F8FC',
              borderColor: '#8C8D8E',
              borderWidth: 1,
              borderRadius: 4,
              rich: {
                a: {
                  color: '#6E7079',
                  lineHeight: 22,
                  align: 'center'
                },
                hr: {
                  borderColor: '#8C8D8E',
                  width: '100%',
                  borderWidth: 1,
                  height: 0
                },
                b: {
                  color: '#4C5058',
                  fontSize: 14,
                  fontWeight: 'bold',
                  lineHeight: 33
                },
                per: {
                  color: '#fff',
                  backgroundColor: '#4C5058',
                  padding: [3, 4],
                  borderRadius: 4
                }
              }
            },
            data: [
              { value: 1048, name: '95分到100分' },
              { value: 335, name: '90分到94分' },
              { value: 310, name: '85分到89分' },
              { value: 251, name: '80分到84分' },
              { value: 234, name: '75分到79分' },
              { value: 147, name: '70分到74分' },
              { value: 135, name: '60分到69分' },
              { value: 102, name: '60分以下' }
            ]
          }
        ]
      };

      option && myChart.setOption(option);
    },
    intmain3(){
      var chartDom = document.getElementById('main3');
      var myChart = echarts.init(chartDom);
      var option;

      option = {
        color: ['#67F9D8', '#FFE434', '#56A3F1', '#FF917C'],
        title: {
          text: '班级学生雷达图'
        },

        toolbox:{
        show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
          mark: { show: true },
          dataView: { show: true, readOnly: false },
          restore: { show: true },
          saveAsImage: { show: true }
        }
      },
        legend: {},
        radar: [
          {
            indicator: [
              { text: '英语' },
              { text: '数学' },
              { text: '心理学测试' },
              { text: '政治' }
            ],
            center: ['25%', '50%'],
            radius: 120,
            startAngle: 90,
            splitNumber: 4,
            shape: 'circle',
            axisName: {
              formatter: '【{value}】',
              color: '#428BD4'
            },
            splitArea: {
              areaStyle: {
                color: ['#77EADF', '#26C3BE', '#64AFE9', '#428BD4'],
                shadowColor: 'rgba(0, 0, 0, 0.2)',
                shadowBlur: 10
              }
            },
            axisLine: {
              lineStyle: {
                color: 'rgba(211, 253, 250, 0.8)'
              }
            },
            splitLine: {
              lineStyle: {
                color: 'rgba(211, 253, 250, 0.8)'
              }
            }
          },
          {
            indicator: [
              { text: '英语', max: 150 },
              { text: '数学', max: 150 },
              { text: '心理学测试', max: 150 },
              { text: '政治', max: 120 }
            ],
            center: ['75%', '50%'],
            radius: 120,
            axisName: {
              color: '#fff',
              backgroundColor: '#666',
              borderRadius: 3,
              padding: [3, 5]
            }
          }
        ],
        series: [
          {
            type: 'radar',
            emphasis: {
              lineStyle: {
                width: 4
              }
            },
            data: [
              {
                value: [100, 8, 0.4, -80, 2000],
                name: '个人总分偏差'
              },
              {
                value: [60, 5, 0.3, -100, 1500],
                name: '总体总分偏差',
                areaStyle: {
                  color: 'rgba(255, 228, 52, 0.6)'
                }
              }
            ]
          },
          {
            type: 'radar',
            radarIndex: 1,
            data: [
              {
                value: [89, 88, 90, 77],
                name: '具体成绩',
                symbol: 'rect',
                symbolSize: 12,
                lineStyle: {
                  type: 'dashed'
                },
                label: {
                  show: true,
                  formatter: function (params) {
                    return params.value;
                  }
                }
              },
              {
                value: [70, 68, 79, 68],
                name: '考试均分',
                areaStyle: {
                  color: new echarts.graphic.RadialGradient(0.1, 0.6, 1, [
                    {
                      color: 'rgba(255, 145, 124, 0.1)',
                      offset: 0
                    },
                    {
                      color: 'rgba(255, 145, 124, 0.9)',
                      offset: 1
                    }
                  ])
                }
              }
            ]
          }
        ]
      };

      option && myChart.setOption(option);
    },

    intmain5(){
      var chartDom = document.getElementById('main5');
      var myChart = echarts.init(chartDom);
      var option;

      function getRandomInt(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
      }

      function getRandomName() {
        const surnames = ['赵', '钱', '孙', '李', '周', '吴', '郑', '王'];
        const names = ['泽', '博', '嘉', '杰', '熙', '然', '坤', '明', '阳', '晗'];
        return surnames[getRandomInt(0, surnames.length - 1)] + names[getRandomInt(0, names.length - 1)];
      }

      function generateStudentData(count) {
        let studentData = [];
        for (let i = 0; i < count; i++) {
          studentData.push({
            'Name': getRandomName(),
            'Math': getRandomInt(35, 100),
            'English': getRandomInt(35, 100),
            'Science': getRandomInt(35, 100),
            'Class': String.fromCharCode(65 + getRandomInt(0, 2)), // A, B, C
            'Grade': getRandomInt(9, 11)
          });
        }
        return studentData;
      }

// 使用generateStudentData函数生成100组学生数据，并赋值给studentData变量
      var studentData = generateStudentData(500);
// 模拟学生考试数据


      var symbolSize = 5; // 稍微增大点符号大小

      option = {
        title: {
          text: '成绩分布3D散点图',
          subtext: '随机500位学生',
          left: 'center'
        },
        toolbox:{
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        grid3D: {},
        xAxis3D: {
          type: 'category',
          name: '学生姓名'
        },
        yAxis3D: {
          name: '数学成绩'
        },
        zAxis3D: {
          name: '英语成绩'
        },
        dataset: {
          dimensions: [
            'Name',
            'Math',
            'English',
            'Science',
            'Class',
            { name: 'Grade', type: 'ordinal' }
          ],
          source: studentData
        },
        series: [
          {
            type: 'scatter3D',
            symbolSize: symbolSize,
            encode: {
              x: 'Name',
              y: 'Math',
              z: 'English',
              tooltip: [0, 1, 2, 3, 4, 5]
            },
            itemStyle: {
              color: function(params) {
                // 根据班级不同显示不同颜色
                var colorMap = {
                  'A': '#c23531',
                  'B': '#2f4554',
                  'C': '#61a0a8'
                };
                return colorMap[params.data.Class] || '#999';
              }
            }
          }
        ],
        tooltip: {},
        visualMap: {
          show: true,
          dimension: 3, // Science成绩
          min: 30,
          max: 100,
          inRange: {
            color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']
          }
        }
      };

      myChart.setOption(option);


    }
  }
}
</script>
