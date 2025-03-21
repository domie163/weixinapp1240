<template>
  <!-- 代码拓展 -->
  <pre class="expand_pre"
    v-highlightjs="code"><button class="copy_btn" @click="$copy(code)" v-if="code"><span>复制</span></button><slot><code :lang="lang" :contenteditable="edit"></code></slot></pre>
</template>

<script>
  import hybrid from 'highlight.js/styles/vs2015.css';

  export default {
    props: {
      code: {
        type: String,
        default: ""
      },
      lang: {
        type: String,
        default: "javascript"
      },
      edit: {
        type: Boolean,
        default: false
      }
    }
  }
</script>

<style>
  .expand_pre {
    position: relative;
  }

  .expand_pre ul {
    list-style: none;
    padding-left: 0;
  }

  .expand_pre .copy_btn {
    position: absolute;
    right: 0.75rem;
    top: 0.75rem;
    padding: 0.25rem 0.75rem;
    border-radius: 0.25rem;
    border: none;
    background: #fff;
    font-size: 0.625rem;
    display: none;
    z-index: 20;
    line-height: 1.5;
    height: auto;
  }

  .expand_pre:hover .copy_btn {
    display: block;
  }

  .expand_pre .copy_btn:active {
    background: rgba(125, 125, 125, 0.25);
  }

  .hljs li {
    line-height: 1.75;
  }

  .hljs li:before {
    float: left;
    content: attr(data-line-number);
    min-width: 2.5rem;
    border-right: 1px solid #c5c5c5;
    word-wrap: normal;
    text-align: right;
    padding-right: 0.5rem;
    margin-right: 0.5rem;
  }
</style>
