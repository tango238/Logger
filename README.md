Logger
======

A kind of Logger for practice

LogManager
　シングルトン。常に同じインスタンスを返す。

LoggerContext
　名前をつけて複数のLoggerContextを生成することができる。
　LogManager以外のロギングに必要なクラスはここから作成される。
　LogManagerからLoggerContextの呼び出しは弱参照で呼び出す。

Logger
　LoggerConfigを持つ。

LoggerConfig
　Appenderを持つ。
