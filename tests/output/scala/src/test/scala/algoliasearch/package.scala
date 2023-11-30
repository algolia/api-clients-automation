package object algoliasearch {

  def value[T](v: T): T = v

  def value[Option[T]](v: T): T = Some(v)
}
